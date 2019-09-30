<?php
namespace Home\Controller;
use Think\Controller;
class IndexController extends Controller {
    public function index(){

        $this->display();
    }

    public function Adduser(){
        $ud = M("update");
        $bus = M("bus");
        $driver = M("driver");
        $bus_location = M("bus_location");
    
        if(empty($_POST)){

        }else{
            $count=$ud->where('busid='.$_POST['busid'])->count();
            $seat = $bus->where('busid='.$_POST['busid'])->find();
            if ($count>=$seat['seat']){
                $this->error("School Bus Already Full","index",2);
            }else{
                $userdate['name'] = $_POST['name'];
                $userdate['userid']=$_POST['userid'];
                $update['busid']=$_POST['busid'];
                $buslocation=$_POST['busloc'];
                $drivername=$_POST['drivername'];
                $update['time']=time();
                $update['getoff']=0;

                $a = $ud->where('userid='.$userdate['userid'])->find();
                $d = $driver->where('driverid='.$drivername)->find();

                if ($a){
                    $this->error("This Passenger Already Get on the School Bus","index",2);
                }else{
                    $location = $bus_location->where('id="'.$buslocation.'"')->find();
                    $update['userid'] = $userdate['userid'];
                    $update['buslocation'] = $location['location'];
                    $z = $ud->add($update);
                    if($z){
                        $this->success("The passenger the on the school bus successful!","index",2);
                    }else{
                        $this->error("Get on the school bus fail!","index",2);
                    }
                }
            }


        }
    }

    public function Deluser(){
        $update = M("update");
        $bus = M("bus");
        $User = M("User");
        if(empty($_POST)){

        }else{

            $n=$_POST['userid'];
            $name=$_POST['name'];

            $a = $User->where('uid='.$n)->find();
            $b = $User->where('name="'.$name.'"')->find();

            if ($a and $b){
                $date['getoff'] = 1;
                $z = $update->where('userid='.$a['uid'])->save($date);

                if($z){
                    $count1 = $update->where('busid='.$_POST['busid'])->count();
                    $seat = $bus->where('busid='.$_POST['busid'])->find();
                    $count = $seat-$count1;
                    $this->success("The passenger already get off the school bus,there are ".$count."passenger on the school bus","index",2);
                }else{
                    $this->error("Get off the school bus fail","index",2);
                }
            }else{
                $this->error("This passenger not on the school bus","index",2);
            }
        }
    }


}