package s11r_test

import grails.gorm.services.Service

@Service(Grouping)
interface GroupingService {

    Grouping get(Serializable id)

    List<Grouping> list(Map args)

    Long count()

    void delete(Serializable id)

    Grouping save(Grouping grouping)

}