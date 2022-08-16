package com.fple.sample.data

import java.util.*
import kotlin.collections.ArrayList


class Model : Observable() {
    val appsList: ArrayList<Data> = ArrayList(4)

    // constructor to initialize the list
    init {
        appsList.add(Data("Carsome", "21.2 MB", "iso_01", "bg_apps1",4.4, "Peanut butter and jelly caused the elderly lady to think about her past. The paintbrush was angry at the color the artist chose to use.", "Educational,Productivity,Utility"))
        appsList.add(Data("Eldywrym", "29.8 MB", "iso_02", "bg_apps2",4.6, "She traveled because it cost the same as therapy and was a lot more enjoyable. He said he was not there yesterday; however, many people saw him there.", "Social,Lifestyle,News"))
        appsList.add(Data("NightShade", "30 MB", "iso_03", "bg_apps3",4.1, "Patricia loves the sound of nails strongly pressed against the chalkboard. The tears of a clown make my lipstick run, but my shower cap is still intact.", "Business,Travel,Finance"))
        appsList.add(Data("Silvermoon", "39.3 MB", "fple_welcome", "bg_apps4",4.9, "She used her own hair in the soup to give it more flavor. She saw no irony asking me to change but wanting me to accept her for who she is.", "Shopping,Entertainment,Food and Drinks"))
    }

    // defining getter and setter functions to return appropriate count value at correct index
    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index: Int): Data {
        return appsList[the_index]
    }

    // function to make changes in the activity button's count value when user touch it
    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(the_index: Int) {
        //List[the_index] = List[the_index] + 1
        setChanged()
        notifyObservers()
    }
}