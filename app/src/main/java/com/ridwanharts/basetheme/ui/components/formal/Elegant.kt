package com.ridwanharts.basetheme.ui.components.formal

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.theme.formal.FormalColors

/**
 * Komponen MODE FORMAL — elegan & dewasa, referensi housemait.com:
 * pill penuh, shadow LEMBUT (bukan hard shadow), garis tipis hangat.
 */

private val PillShape = RoundedCornerShape(percent = 50)

/** Tombol utama elegan: pill ungu + soft shadow sewarna aksen. */
@Composable
fun ElegantButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val container by animateColorAsState(
        targetValue = when {
            !enabled -> FormalColors.Line
            pressed -> FormalColors.PrimaryDark
            else -> FormalColors.Primary
        },
        label = "elegantButton",
    )
    Box(
        modifier = modifier
            .shadow(10.dp, PillShape, spotColor = FormalColors.Primary.copy(alpha = 0.35f))
            .clip(PillShape)
            .background(container)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick,
            )
            .padding(horizontal = 28.dp, vertical = 15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            leadingIcon?.invoke()
            Text(
                text = text,
                color = if (enabled) Color.White else FormalColors.InkFaint,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
            )
        }
    }
}

/** Tombol sekunder elegan: putih, garis tipis, teks ink. */
@Composable
fun ElegantOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .clip(PillShape)
            .background(Color.White)
            .border(1.dp, FormalColors.Line, PillShape)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 28.dp, vertical = 15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            leadingIcon?.invoke()
            Text(
                text = text,
                color = if (enabled) FormalColors.Ink else FormalColors.InkFaint,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
            )
        }
    }
}

/** Kartu elegan: putih, radius 20dp, soft shadow sangat halus. */
@Composable
fun ElegantCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val shape = RoundedCornerShape(20.dp)
    Column(
        modifier = modifier
            .shadow(8.dp, shape, spotColor = FormalColors.Ink.copy(alpha = 0.10f))
            .clip(shape)
            .background(Color.White)
            .border(1.dp, FormalColors.Line, shape)
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier,
            )
            .padding(24.dp),
        content = content,
    )
}

/** Input elegan: radius 14dp, garis hangat, fokus ungu. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElegantTextField(
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
        shape = RoundedCornerShape(14.dp),
        textStyle = TextStyle(color = FormalColors.Ink, fontSize = 15.sp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = FormalColors.Primary,
            unfocusedBorderColor = FormalColors.Line,
            cursorColor = FormalColors.Primary,
            focusedLabelColor = FormalColors.Primary,
            unfocusedLabelColor = FormalColors.InkFaint,
            focusedTextColor = FormalColors.Ink,
            unfocusedTextColor = FormalColors.Ink,
        ),
    )
}
