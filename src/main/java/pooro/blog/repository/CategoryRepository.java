package pooro.blog.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pooro.blog.domain.Category;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    public Long save(Category category) {
        em.persist(category);
        return category.getId();
    }

    public Category findByName(String name) {
        List<Category> result =  em.createQuery("select c from Category c where c.name = :name")
                .setParameter("name", name)
                .getResultList();

        return result.get(0);
    }
}
