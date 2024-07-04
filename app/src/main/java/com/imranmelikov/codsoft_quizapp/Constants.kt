package com.imranmelikov.codsoft_quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1,
           "Macos",
            "Linux", "Windows",
            "Android", R.drawable.linux, 2
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "Linux",
            "Android", "IOS",
            "Windows", R.drawable.windows, 4
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Macos",
            "Windows", "Android",
            "Linux", R.drawable.apple, 1
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "IOS",
            "Android", "Windows",
            "Linux", R.drawable.android, 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "IOS",
            "Windows", "Android",
            "Linux", R.drawable.apple, 1
        )

        questionsList.add(que5)

        return questionsList
    }

    fun answer(answer:String,position:Int):Boolean{
        return when {
            answer=="Linux" && position==1 -> true
            answer=="Windows"&&position==2 -> true
            answer=="Macos"&&position==3 -> true
            answer=="Android"&&position==4 -> true
            answer=="IOS" && position==5 -> true
            else -> false
        }
    }

}