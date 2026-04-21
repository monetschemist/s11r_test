package s11r_test

import java.time.LocalDate

class Member {

	static belongsTo = [grouping: Grouping, person: Person]
	LocalDate start, end

    static constraints = {
		grouping nullable: false
		person nullable: false
		start nullable: false
		end nullable: false
    }
}
