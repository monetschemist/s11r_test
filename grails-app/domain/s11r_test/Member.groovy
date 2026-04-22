package s11r_test

import java.time.LocalDate

class Member {

	static belongsTo = [grouping: Grouping, person: Person]
	LocalDate startDate, endDate

    static constraints = {
		grouping nullable: false
		person nullable: false
		startDate nullable: false
		endDate nullable: false
    }
}
