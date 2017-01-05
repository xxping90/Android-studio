/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.notepad;

import android.test.ActivityInstrumentationTestCase2;

import com.example.android.notepad.NotesList;
import com.robotium.solo.Solo;
/**
 * Make sure that the main launcher activity opens up properly, which will be
 * verified by {@link #testActivityTestCaseSetUpProperly}.
 */

public class NotePadTest extends ActivityInstrumentationTestCase2
{
    private Solo solo;//…˘√˜Solo
    public NotePadTest()//ππ‘Ï∑Ω∑®
    {
        super(NotesList.class);

    }

    @Override
    public void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

    public void testAddNote() throws Exception
    {
        //µ„ª˜add note∞¥≈•
        solo.clickOnMenuItem("Add note");
        //±»∂‘Ω·π˚
        solo.assertCurrentActivity("Expected NoteEditor activity", "NoteEditor");
        //‘⁄µ⁄“ª∏ˆTextEditøÿº˛…œ ‰»Îƒ⁄»›
        solo.enterText(0, "Note 1");
        //∑µªÿ…œ∏ˆΩÁ√Ê
        solo.goBack();
        //µ„ª˜≤Àµ•÷–µƒAdd note
        solo.clickOnMenuItem("Add note");
        //‘⁄µ⁄“ª∏ˆEditText÷– ‰»Îƒ⁄»›
        solo.enterText(0, "Note 2");
        //∑µªÿNotesList activity
        solo.goBackToActivity("NotesList");
        //Ωÿ∆¡
        solo.takeScreenshot();
        boolean expected = true;
        boolean actual = solo.searchText("Note 1")&&solo.searchText("Note 2");
        assertEquals("Note 1 and/or Note 2 are not found", expected, actual);

    }
}