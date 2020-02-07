package com.cassiano.starwars

import androidx.test.core.app.ApplicationProvider
import com.cassiano.starwars.home.model.Distance
import com.cassiano.starwars.home.model.PickDropData
import com.cassiano.starwars.home.model.Pilot
import com.cassiano.starwars.home.model.PilotData
import com.cassiano.starwars.home.viewmodel.MainViewModel
import io.mockk.clearAllMocks
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {

    private lateinit var viewModelMock: MainViewModel
    private lateinit var pilotData: PilotData
    private lateinit var pilot: Pilot
    private lateinit var distance: Distance
    private lateinit var pickUp: PickDropData
    private lateinit var dropOff: PickDropData
    private var list = ArrayList<PilotData>()

    @Before
    fun init() {
        clearAllMocks()

        viewModelMock = MainViewModel(ApplicationProvider.getApplicationContext())
        pilot = Pilot("Yoda", "/myAvatar", 4.0f)
        distance = Distance(123123123L, "km")
        pickUp = PickDropData("Death Star", "/amazingPic", "2017-12-09T14:12:51Z")
        dropOff = PickDropData("Yavin 4", "/amazingPic2", "2017-12-09T19:35:51Z")
        pilotData = PilotData(1, pilot, distance, 19427000, pickUp, dropOff)
        list.add(pilotData)
        viewModelMock.list = list
    }

    @Test
    fun `checks pilot data`() {

        viewModelMock.run {
            pilotData.pilot.run {
                Assert.assertEquals(this?.name, "Yoda")
                Assert.assertEquals(this?.rating, 4.0f)
            }
        }
    }

    @Test
    fun `checks distance data`() {
        viewModelMock.run {
            pilotData.distance.run {
                Assert.assertEquals(this?.value, 123123123L)
                Assert.assertEquals(this?.unit, "km")
            }
        }
    }

    @Test
    fun `checks pick up data`() {
        viewModelMock.run {
            pilotData.pickUp.run {
                Assert.assertEquals(this?.name, "Death Star")
                Assert.assertEquals(this?.date, "2017-12-09T14:12:51Z")
            }
        }
    }

    @Test
    fun `checks drop off data`() {
        viewModelMock.run {
            pilotData.pickUp.run {
                Assert.assertEquals(this?.name, "Yavin 4")
                Assert.assertEquals(this?.date, "2017-12-09T19:35:51Z")
            }
        }
    }

    @Test
    fun `checks if the list is not empty`() {
        viewModelMock.run {
            Assert.assertFalse(list.isEmpty())
        }
    }
}