package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.factories.AddressFactory;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.models.Association;

@Stateless
public class AssociationRepos {
	
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createAssociationRepos(AssociationDto associationDto) {
		Association association = AssociationFactory.fromAssociationDto(associationDto);
		entityManager.persist(association);
	}

	//READ
	public AssociationDto findAssociationRepos(Long id) {

		AssociationDto associationDto= AssociationFactory.fromAssociation(entityManager.find(Association.class, id));	
		return associationDto;
	}

	public List<AssociationDto> listAssociationRepos(){
		return this.entityManager.createNamedQuery("association.findAll", Association.class).getResultList().stream().map(association -> AssociationFactory.fromAssociation(association)).collect(Collectors.toList());
	}

	//UPDATE
	public Association updateAssociationRepos(AssociationDto associationToUpdate) {
		Association association = AssociationFactory.fromAssociationDto(associationToUpdate);
		return entityManager.merge(association);
	}
	
	//DELETE
	
	public void deleteAssociationRepos(Long id) {
		Association association = entityManager.find(Association.class, id);
		if(association != null) {
			entityManager.remove(association);
		}
	}
	
	
	
	
	
	
	
	
	/*    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    public Member findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(member).where(cb.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Member> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(member).orderBy(cb.asc(member.get("name")));
        return em.createQuery(criteria).getResultList();
    }
    
    -----------------------------------------------------------------------
    
    	public List<Course> findCourses() {
		return em.createQuery("Select c From Course c", Course.class).getResultList();
	}

	public Course findCourse(Long n) {
		return em.find(Course.class, n);
	}

	public Course saveCourse(Course c) {
		if (c.getId() == null) {
			em.persist(c);
		} else {
			c = em.merge(c);
		}
		return c;
	}

	public void deleteCourse(Course c) {
		c = em.merge(c);
		em.remove(c);
	}
    
    */

}
