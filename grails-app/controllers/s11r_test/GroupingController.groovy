package s11r_test

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GroupingController {

    GroupingService groupingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond groupingService.list(params), model:[groupingCount: groupingService.count()]
    }

    def show(Long id) {
        respond groupingService.get(id)
    }

    def create() {
        respond new Grouping(params)
    }

    def save(Grouping grouping) {
        if (grouping == null) {
            notFound()
            return
        }

        try {
            groupingService.save(grouping)
        } catch (ValidationException e) {
            respond grouping.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'grouping.label', default: 'Grouping'), grouping.id])
                redirect grouping
            }
            '*' { respond grouping, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond groupingService.get(id)
    }

    def update(Grouping grouping) {
        if (grouping == null) {
            notFound()
            return
        }

        try {
            groupingService.save(grouping)
        } catch (ValidationException e) {
            respond grouping.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'grouping.label', default: 'Grouping'), grouping.id])
                redirect grouping
            }
            '*'{ respond grouping, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        groupingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'grouping.label', default: 'Grouping'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'grouping.label', default: 'Grouping'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
