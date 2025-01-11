package com.example.chatbot

data class ChatData (
    val message : String,
    val role : String
)


// Enums are designed to represent constants or immutable values.
// The role property in each constant is not expected to change during runtime.
//Using val ensures the role remains immutable.

// Enums are typically used in contexts
// where the values are fixed and predefined,
// such as API roles

// Yes, you can technically use var instead of val, but it is not recommended.
// If you declare the property as var,
// the value of role can be modified after the enum constant is created,
// which is usually not desired for enums.

enum class ChatRoleEnum(val role:String){
    USER("user"),
    MODEL("model")
}
