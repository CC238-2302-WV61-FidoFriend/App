package Beans

class LoginBody {
    var email: String
    var password: String

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}