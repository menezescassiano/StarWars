package com.cassiano.starwars

import com.cassiano.starwars.utils.StringFormatUtils
import io.mockk.clearAllMocks
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class StringFormatUtilsTest {

    private lateinit var stringDate: String
    private var distance: Long = 0
    private var duration = 0

    @Before
    fun init() {
        clearAllMocks()
        stringDate = "2017-12-09T14:12:51Z"
        distance = 24785727853
        duration = 19427000
    }

    @Test
    fun `get time format`() {
        Assert.assertEquals(StringFormatUtils.getTime(stringDate), "2:12 PM")
    }

    @Test
    fun `get distance format`() {
        Assert.assertEquals(StringFormatUtils.getDistanceFormated(distance), "24,785,727,853")
    }

    @Test
    fun `get duration format`() {
        Assert.assertEquals(StringFormatUtils.getHourMinSecFormat(duration), "5:23:47")
    }

}