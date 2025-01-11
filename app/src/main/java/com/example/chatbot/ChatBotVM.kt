package com.example.chatbot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

//import com.google.ai.client.generativeai.GenerativeModel
//import com.example.generative.GenerativeModel

class ChatBotVM: ViewModel() {
    // to show our chat with AI on screen from logcat
    val list by lazy{
        mutableStateListOf<ChatData>()
    }


    private val genAI by lazy{ // lazy comes in coroutine
        GenerativeModel(
         modelName = "gemini-pro",
            apiKey = /*YOUR_APIKEY*/
        )
    }

    // to start gen AI by sending message
    fun sendMessage(message:String)=viewModelScope.launch {
        //        viewModelScope.launch  is a part of coroutine and suspended function so we will work inside ir
//       var response: String? = genAI.startChat().sendMessage(prompt = message).text
    // String? means response can either Hold a string value ot Be null


        //Chat here is a class or interface that is predefined in your project or a library
        // you are using (e.g., a generative AI SDK).
        // It represents the structure or behavior of a chat session,
        // typically in applications that involve AI-based conversational functionality.


        // Encapsulate a Chat Session:
        //Represents a single conversation session with the AI.
        //Manages the context, state, or history of the chat.

        // It might internally manage a list of
        // messages exchanged between the user and the AI.
        val chat: Chat = genAI.startChat()
        list.add(ChatData(message,ChatRoleEnum.USER.role)) // ye message user se aaya

        chat.sendMessage(
            content (ChatRoleEnum.USER.role){
                text(message)
            }
        ).text?.let {
            list.add(ChatData(it,ChatRoleEnum.MODEL.role)) // it is model's response
        }  // let jab chalega when response is not empty
// now after this apni sari chat list variable me hai , we need to display them

//        Log.d("AI_ANS",response.toString()) // cast in to string coz response is nullable


        //AI_ANS is a large language model, trained by Google. It is a neural network that has been trained on a massive amount of text data,

        //Once AI_ANS has understood your question, it then tries to generate an answer. It does this by using the knowledge that it has learned from the data that it has been trained on, and by using its own reasoning abilities.


    }


}