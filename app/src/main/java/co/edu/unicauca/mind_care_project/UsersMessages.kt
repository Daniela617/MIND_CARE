package co.edu.unicauca.mind_care_project
class  UsersMessages{
    companion object Database{
        fun getUserInfo():List<UserInfo> {
            return listOf(
                UserInfo(
                    user = "VisitanteX",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac odio nec turpis pulvinar facilisis. Proin quis tortor a velit sollicitudin eleifend. Nullam consectetur arcu at mi ullamcorper"
                ),
                UserInfo(
                    user = "Anon555",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac odio nec turpis pulvinar facilisis. Proin quis tortor a velit sollicitudin eleifend. Nullam consectetur arcu at mi ullamcorper"
                ),
                UserInfo(
                    user = "Host123",
                    contentText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                ),
            )
        }

    }

}
data class UserInfo(
    val user: String,
    val contentText: String
)
