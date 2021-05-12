<?php

namespace App\Controller;

use App\Entity\Products;
use App\Entity\Favourites;
use http\Env\Request;
use phpDocumentor\Reflection\Types\Integer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Doctrine\ORM\Tools\Pagination\Paginator;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\SerializerInterface;

class FavsController extends AbstractController
{



    /**
     * @Route("/favs", name="favs")
     */
    public function index(): Response
    {
        $currentPage = 20;
        $repository=$this->getDoctrine()->getRepository(Products::class);
        $products=$repository->findAll();
       // $paginator = $this->paginate($products, $currentPage);

     //   return $paginator;
        return $this->render('favs/index.html.twig', [
            'controller_name' => 'FavsController','products'=>$products
        ]);
    }
    public function inputcontrol($i,$j):? int
    {
        $repository=$this->getDoctrine()->getRepository(Favourites::class);
        $result=$repository->findBy(array('user_id' => $i,'Product_id'=>$j)
          );
        if($result!=null)
        {
            return 1;
        }
        else {
            return - 1;
        }
    }
    /**
     * @Route("/addtofavsmobile/{user}/{product}", name="add2favsmobile")
     */
    public function addfavsmobile(int $user,int $product)
    {
        $Fav = new Favourites($user,$product);
        $em=$this->getDoctrine()->getManager();
        $em->persist($Fav);
        $em->flush();
        return new Response('Groupe added');
    }
    /**
     * @Route("/deletefavsmobile/{user}/{product}", name="add2favsmobile")
     */
    public function deletefavsmobile(int $user,int $product)
    {
        $activ_user_id=$this->getactiveuserId();
        $em = $this->getDoctrine()->getManager();
        $repository=$this->getDoctrine()->getRepository(Favourites::class);
        $Fav = new Favourites($user,$product);
        //$repository=$this->getDoctrine()->getRepository(Favourites::class);
        //$f=$repository->findBy(['userId' => $activ_user_id],['productId'=>$id]);
        $query = $em->createQuery('
        delete  from
       App\Entity\Favourites f 
        where f.userId = :_user
        and f.productId = :_product
        ');
        $query->setParameter(":_user", $user);
        $query->setParameter(":_product", $product);
        $products = $query->getResult();
        return new Response('Group deleted');
    }
    /**
     * @Route("/addtofavs{id}", name="add2favs")
     */

    public function add($id)
    {
        $activ_user_id=$this->getactiveuserId();
        $entityManager = $this->getDoctrine()->getManager();
        $Fav = new Favourites($activ_user_id,$id);
        $repository=$this->getDoctrine()->getRepository(Favourites::class);
       // $result=$repository->findBy(['userId' => $activ_user_id],['productId'=>$id]);
       // if($result==null)
        //{
            $entityManager->persist($Fav);
        $entityManager->flush();
        //}
        return $this->redirectToRoute('favs');
    }
    /**
     * @Route("/deletefromfavs{id}", name="delete")
     */
    public function delete($id)
    {
        $activ_user_id=$this->getactiveuserId();
        $em = $this->getDoctrine()->getManager();
        $repository=$this->getDoctrine()->getRepository(Favourites::class);
        $Fav = new Favourites($activ_user_id,$id);
        //$repository=$this->getDoctrine()->getRepository(Favourites::class);
        //$f=$repository->findBy(['userId' => $activ_user_id],['productId'=>$id]);
        $query = $em->createQuery('
        delete  from
       App\Entity\Favourites f 
        where f.userId = :_user
        and f.productId = :_product
        ');
        $query->setParameter(":_user", $activ_user_id);
        $query->setParameter(":_product", $id);
        $products = $query->getResult();
        return $this->redirectToRoute('list');
        return $this->render('favs/myfavourites.html.twig', [
            'controller_name' => 'FavsController','products'=>$products,]);


    }
    /**
     * @Route("/login", name="login")
     */
   public function login()
   {

       return $this->render('favs/login.html.twig', [
           'controller_name' => 'ProductController',]);
   }


    public function getactiveuserId():?int
    {
        $em= $this->getDoctrine()->getManager();
        $query1 = $em->createQuery('select max(u.userConnected) as cn from App\Entity\Users u 
         ');

        $result1 = $query1->getResult();
        $connected=$result1;
        $cn=0;
        foreach ($connected as $c)
        {
            $cn=$c['cn'];
            break;

        }
        $query = $em->createQuery('select u.userId as ID  from App\Entity\Users u 
         where u.userConnected = :_conn  ');
        $query->setParameter(":_conn", $cn);
        $result = $query->getResult();
        $id=0;
        foreach ($result as $r)
        {

            $id=$r['ID'];
            break;

        }
        return $id;
    }
    /**
     * @Route("/showactivuser", name="activ_user", methods={"GET","POST"})
     */
    public function getactivuser()
    {
        $e= $_POST['Email'];
        $p= $_POST['password'];
        $em= $this->getDoctrine()->getManager();
        $query1 = $em->createQuery('select max(u.userConnected)+1 as cn from App\Entity\Users u  ');

        $result1 = $query1->getResult();
        $connected=$result1;
        foreach ($connected as $c)
        {
            $cn[]=$c['cn'];
            break;

        }
        $query = $em->createQuery('
        update App\Entity\Users u
        set u.userConnected = :_conn
        where u.userEmail=:_mail 
        and
        u.userPassword=:_pass
        ');
        $query->setParameter(":_conn", $cn[0]);
        $query->setParameter(":_mail", $e);
        $query->setParameter(":_pass", $p);
        $query->getResult();

        return $this->redirectToRoute('favs');
       // return $c;
        return $this->render('favs/a.html.twig', [
            'controller_name' => 'ProductController','e'=>$e,'p'=>$p,'id'=>$this->getactiveuserId()
        ]);
    }
    static $userId;

    /**
     * @Route("/listfav", name="list" ,methods={"GET","POST"})

     * @return Response
     */

    public function list()
    {

        $activ_user_id=$this->getactiveuserId();
        $repository=$this->getDoctrine()->getRepository(Favourites::class);
        $em= $this->getDoctrine()->getManager();

        $query = $em->createQuery('
        select
        p.productId as id,p.productName as n,p.category as c,p.price as pr,p.quantity as q,p.teamId as t,p.img as i
        from App\Entity\Products p
        LEFT JOIN App\Entity\Favourites f WITH f.productId=p.productId
        where f.userId = :_user
        
        ');
        $query->setParameter(":_user", $activ_user_id);
        $products = $query->getResult();

        return $this->render('favs/myfavourites.html.twig', [
            'controller_name' => 'FavsController','products'=>$products,
        ]);
    }
    /**
     * @Route("/listfavmob/{id}", name="listfavmobile" ,methods={"GET","POST"})

     * @return Response
     */
    public function viewfavouritesinmobile($id,SerializerInterface $serializer)
    {

        $repository=$this->getDoctrine()->getRepository(Favourites::class);
        $em= $this->getDoctrine()->getManager();


        $query = $em->createQuery('
        select
        p.productId as id,p.productName as n,p.category as c,p.price as pr,p.quantity as q,p.teamId as t,p.img as i
        from App\Entity\Products p
        LEFT JOIN App\Entity\Favourites f WITH f.productId=p.productId
        where f.userId=:_user 
        
        ');
        $query->setParameter(":_user", intval($id));
        $products = $query->getResult();
        //return $this->redirectToRoute('list');


        $formatted = $serializer->normalize($products);
        return new JsonResponse($formatted);
    }

    /**
     * @Route("/setactiveuser/{userid}", name="viewfavouritesinmobile")
     */
    public function setactivuser($userid)
    {
        $em= $this->getDoctrine()->getManager();
        $query1 = $em->createQuery('select max(u.userConnected)+1 as cn from App\Entity\Users u  ');

        $result1 = $query1->getResult();
        $connected=$result1;
        foreach ($connected as $c)
        {
            $cn[]=$c['cn'];
            break;

        }
        $query = $em->createQuery('
        update App\Entity\Users u
        set u.userConnected = :_conn
        where u.userId=:_id 
        
        ');
        $query->setParameter(":_conn", $cn[0]);
        $query->setParameter(":_id", $userid);

        $query->getResult();
        return new Response('');


    }
    /**
     * @Route("/getactivusemob", name="activusermob" ,methods={"GET","POST"})

     * @return Response
     */
    public function getactiveuserIdmobile(SerializerInterface $serializer)
    {
        $em= $this->getDoctrine()->getManager();
        $query1 = $em->createQuery('select max(u.userConnected) as cn from App\Entity\Users u 
         ');

        $result1 = $query1->getResult();
        $connected=$result1;
        $cn=0;
        foreach ($connected as $c)
        {
            $cn=$c['cn'];
            break;

        }

        $query = $em->createQuery('select u.userId as ID  from App\Entity\Users u 
         where u.userConnected = :_conn  ');
        $query->setParameter(":_conn", $cn);
        $result = $query->getResult();
        $id=0;
        foreach ($result as $r)
        {

            $id=$r['ID'];
            break;

        }

        $formatted = $serializer->normalize($id);
        return new JsonResponse($formatted);
    }
    public function  deletefromfavourites($i,$j)
    {

    }

}
