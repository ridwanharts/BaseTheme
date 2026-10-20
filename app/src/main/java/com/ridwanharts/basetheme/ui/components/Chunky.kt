package com.ridwanharts.basetheme.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.theme.WanColors

/**
 * Hard shadow khas gaya chunky: bayangan tegas tanpa blur,
 * digeser 4dp ke kanan-bawah. Digambar DI BELAKANG komponen.
 *
 * Urutan modifier penting: panggil ini SEBELUM .background(...).
 */
fun Modifier.chunkyShadow(
    offset: Dp = 4.dp,
    color: Color = WanColors.Brand900,
    radius: Dp = 18.dp,
): Modifier = this.drawBehind {
    val px = offset.toPx()
    drawRoundRect(
        color = color,
        topLeft = Offset(px, px),
        size = Size(size.width, size.height),
        cornerRadius = CornerRadius(radius.toPx(), radius.toPx()),
    )
}

/**
 * Tombol utama chunky: border 2dp + hard shadow.
 * Saat ditekan, bayangan menghilang & tombol bergeser (efek "tertekan").
 */
@Composable
fun ChunkyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = WanColors.Brand500,
    contentColor: Color = Color.White,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val shadow by animateDpAsState(
        targetValue = if (pressed) 0.dp else 4.dp,
        label = "chunkyShadow",
    )
    val shift by animateDpAsState(
        targetValue = if (pressed) 4.dp else 0.dp,
        label = "chunkyShift",
    )
    val shape = RoundedCornerShape(18.dp)
    Box(
        modifier = modifier
            .graphicsLayer {
                translationX = shift.toPx()
                translationY = shift.toPx()
                alpha = if (enabled) 1f else 0.5f
            }
            .chunkyShadow(offset = shadow, color = WanColors.Brand900, radius = 18.dp)
            .clip(shape)
            .background(containerColor)
            .border(2.dp, WanColors.Brand900, shape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick,
            )
            .padding(horizontal = 20.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            leadingIcon?.invoke()
            Text(
                text = text,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        }
    }
}

/** Tombol sekunder chunky: latar putih, teks tinta. */
@Composable
fun ChunkySecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    ChunkyButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = Color.White,
        contentColor = WanColors.Ink,
        leadingIcon = leadingIcon,
    )
}

/** Kartu chunky: putih, border garis, hard shadow lembut. */
@Composable
fun ChunkyCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val shape = RoundedCornerShape(24.dp)
    Column(
        modifier = modifier
            .chunkyShadow(offset = 4.dp, color = WanColors.ShadowCard, radius = 24.dp)
            .clip(shape)
            .background(Color.White)
            .border(2.dp, WanColors.Line, shape)
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier,
            )
            .padding(20.dp),
        content = content,
    )
}

/** Input chunky: radius 16dp, fokus biru. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChunkyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        leadingIcon = leadingIcon,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(16.dp),
        textStyle = TextStyle(color = WanColors.Ink, fontSize = 15.sp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = WanColors.Brand400,
            unfocusedBorderColor = WanColors.Line,
            cursorColor = WanColors.Brand500,
            focusedLabelColor = WanColors.Brand600,
            unfocusedLabelColor = WanColors.InkFaint,
            focusedTextColor = WanColors.Ink,
            unfocusedTextColor = WanColors.Ink,
        ),
    )
}
