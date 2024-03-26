package kz.sd.apteka.firebase

data class User(
    var name: String? = null,
    var lastname: String?= null,
    var pictureUrl: String? = null,
    var address:String? = null,
    var cart: Map<String, Product> = emptyMap(),
    var bonus:Double? = 0.0,
)