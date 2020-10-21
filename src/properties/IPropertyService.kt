package properties

import users.User

interface IPropertyService {
    fun getOwnerOfProperty(property: Property): User
}