package com.crudUser.crudUserProgram.crudUserPackage;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping ({"/routeuser"})
public class UserController implements crudUserInterface {

    User u  ;
    ArrayList<User> arr = new ArrayList<>();

//    @GetMapping ("/")
//    public String sayHello()
//    {
//        return "say hello : user ";
//    }


    @GetMapping ("{userId}")
    public User getUserDetails ( String userId  )
    {    User  element = null;
         for (  User   ele : arr )
         {
             if ( ele.getUserId() == userId )
             {
                 element  = ele ;
                 break ;
             }
         }
         return element ;
    }



    @PostMapping
    public String createUser (@RequestBody User  obj )
    {


        this.u = obj ;
        arr.add(obj);
        return "user created succesfully ";
    }

    @PutMapping("{userId}")
    public User updateUser (@PathVariable String userId , @RequestBody User obj   )
    {
          User b = obj;
           for (User a : arr)
           {
                if (a.getUserId() == userId  )
                {
                    a = b ;
                }
           }
           return b ;

        //this.u = obj ;
        //return "user updated successfully";
    }

    @DeleteMapping("{userId}")
     public String deleteUser ( String id )
    {

        for ( User ele : arr )
        {
            if ( ele.getUserId() == id  )
            {
                ele = null ;
                break ;
            }
        }
        //this.u = null ;
        return "employee deleted successfully" ;
    }

    @GetMapping ("/userlist")
    public ArrayList<User> getUserList ()
    {
        return arr ;
    }



}
