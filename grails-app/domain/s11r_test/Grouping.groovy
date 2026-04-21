package s11r_test

class Grouping {

	Grouping parent
	static hasMany = [subgroupings: Grouping, members: Member]
	String name

    static constraints = {
		parent nullable: true
		subgroupings nullable: true
		members nullable: true
		name nullable: false, blank: false
    }
}
