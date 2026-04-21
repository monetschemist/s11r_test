package s11r_test

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GroupingServiceSpec extends Specification {

    GroupingService groupingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Grouping(...).save(flush: true, failOnError: true)
        //new Grouping(...).save(flush: true, failOnError: true)
        //Grouping grouping = new Grouping(...).save(flush: true, failOnError: true)
        //new Grouping(...).save(flush: true, failOnError: true)
        //new Grouping(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //grouping.id
    }

    void "test get"() {
        setupData()

        expect:
        groupingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Grouping> groupingList = groupingService.list(max: 2, offset: 2)

        then:
        groupingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        groupingService.count() == 5
    }

    void "test delete"() {
        Long groupingId = setupData()

        expect:
        groupingService.count() == 5

        when:
        groupingService.delete(groupingId)
        sessionFactory.currentSession.flush()

        then:
        groupingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Grouping grouping = new Grouping()
        groupingService.save(grouping)

        then:
        grouping.id != null
    }
}
