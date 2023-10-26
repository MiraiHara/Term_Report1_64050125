/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jjsoc
 */

public class ShoppingcartTable {
    public static List<Shoppingcart> findAllCart() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppcationShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> spList = null;
        try {
            spList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return spList;
    }
    
    public static List<Shoppingcart> finCartById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppcationShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> spList = null;
        try {
            spList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return spList;
    }
    
    public static int insertCart(Shoppingcart cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppcationShoppingPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cart);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    //อธิบาย CART_ID
    /*โค้ดพยายามดึงรายการของตะกร้าช็อปปิ้งจากฐานข้อมูลโดยใช้ named query ชื่อ "Shoppingcart.findAll." 
    ถ้า check ไปแล้วไม่มีจะแทน 1 ไปตรงๆ , ถ้ามีโค้ดจะส่งค่าเพิ่มไปอีก 1*/
    public static int GenerateId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppcationShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> spList = null;
        try {
            spList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            if (spList.isEmpty()) {
                return 1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        /*ดึงตัว cart ล่าสุดมา*/
        Shoppingcart lastShoppingcart = spList.get(spList.size() - 1);
        return lastShoppingcart.getShoppingcartPK().getCartId() + 1;
    }
}
