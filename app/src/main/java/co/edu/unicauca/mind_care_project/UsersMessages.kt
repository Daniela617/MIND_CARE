package co.edu.unicauca.mind_care_project
class  UsersMessages{
    companion object Database{
        fun getUserInfo():List<UserInfo> {
            return listOf(
                UserInfo(
                    imageId = R.drawable.avatar2,
                    user = "VisitanteX",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac odio nec turpis pulvinar facilisis. Proin quis tortor a velit sollicitudin eleifend. Nullam consectetur arcu at mi ullamcorper"
                ),
                UserInfo(
                    imageId = R.drawable.avatar3,
                    user = "Anon555",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac odio nec turpis pulvinar facilisis. Proin quis tortor a velit sollicitudin eleifend. Nullam consectetur arcu at mi ullamcorper"
                ),
                UserInfo(
                    imageId = R.drawable.avatar4,
                    user = "Host123",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                ),
            )
        }

    }

}
data class UserInfo(
    val imageId: Int,
    val user: String,
    val contentText: String
)
