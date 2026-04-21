package s11r_test

class Person {

	static hasMany = [memberships: Member]
	String surname
	String givenNames

    static constraints = {
		memberships nullable: true
		surname nullable: false, blank: false
		givenNames nullable: false, blank: false
    }
}
