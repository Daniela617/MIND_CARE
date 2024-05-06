package co.edu.unicauca.mind_care_project.singleton

object IdManager {
    private var id: String = ""
    private var varNombre : String = ""
    fun assignId(newId: String) {
        id = newId
    }
    fun getAssignId(): String {
        return this.id
    }
    fun assignName(newName: String) {
        varNombre = newName
    }
    fun getAssignName(): String {
        return this.varNombre
    }
}