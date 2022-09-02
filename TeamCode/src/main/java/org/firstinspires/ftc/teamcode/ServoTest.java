package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoTest extends LinearOpMode{
    private Servo arm;
    boolean armRunning = false;

    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.servo.get("arm");

        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                if(armRunning == false){
                    armRunning = true;
                    arm.setPosition(1);
                }else armRunning = false;
            }
            if(armRunning){
                if(arm.getPosition() > 0.9){
                    arm.setPosition(0);
                }if(arm.getPosition()<0.1){
                    arm.setPosition(1);
                }
            }
        }
    }
}
