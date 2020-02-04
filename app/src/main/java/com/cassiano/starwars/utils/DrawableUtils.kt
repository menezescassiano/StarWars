package com.cassiano.starwars.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.cassiano.starwars.R
import com.cassiano.starwars.enum.PilotName.*

object DrawableUtils {

    fun getDrawable(context: Context, @DrawableRes drawableRes: Int): Drawable? {
        return try {
            ContextCompat.getDrawable(context, drawableRes)
                ?: VectorDrawableCompat.create(context.resources, drawableRes, null)
        } catch (e: Resources.NotFoundException) {
            null
        }
    }

    fun getAvatar(context: Context, name: String): Drawable? {
        return when(name) {
            DARK_VADOR.pilot -> getDrawable(context, R.drawable.dark_vador)
            ADMIRAL_ACKBAR.pilot -> getDrawable(context, R.drawable.admiral_ackbar)
            BOBA_FETT.pilot -> getDrawable(context, R.drawable.boba_fett)
            CHEWEE.pilot -> getDrawable(context, R.drawable.chewee)
            DARTH_MAUL.pilot -> getDrawable(context, R.drawable.darth_maul)
            EMPEROR_PALPATINE.pilot -> getDrawable(context, R.drawable.emperor_palpatine)
            GENERAL_GRIEVOUS.pilot -> getDrawable(context, R.drawable.general_grievous)
            GRAND_MOFF.pilot -> getDrawable(context, R.drawable.grand_moff)
            HAN_SOLO.pilot -> getDrawable(context, R.drawable.han_solo)
            LEIA.pilot -> getDrawable(context, R.drawable.leia)
            LUKE.pilot -> getDrawable(context, R.drawable.luke)
            YODA.pilot -> getDrawable(context, R.drawable.yoda)
            else -> getDrawable(context, R.drawable.admiral_ackbar)
        }
    }

    fun getStarRating(context: Context, index: Int, count: Float): Drawable? {
        if (count == 0.0f) {
            return null
        } else if (index <= count) {
            return DrawableUtils.getDrawable(context, R.drawable.filled_star)
        }
        return DrawableUtils.getDrawable(context, R.drawable.empty_star)
    }
}