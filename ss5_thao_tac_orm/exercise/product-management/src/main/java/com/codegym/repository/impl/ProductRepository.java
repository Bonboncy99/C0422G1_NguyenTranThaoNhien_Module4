package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(
                "select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        entityTransaction.commit();
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
//        TypedQuery<Product>typedQuery = BaseRepository.entityManager.createQuery(
//                "select p from Product p " +
//                        "where p.id = :productId",Product.class);
//        typedQuery.setParameter("productId",id);
//
//        return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(
                "select p from Product p  where p.name like :productName",Product.class);
        typedQuery.setParameter("productName","%"+name+"%");
        return typedQuery.getResultList();
    }
}
