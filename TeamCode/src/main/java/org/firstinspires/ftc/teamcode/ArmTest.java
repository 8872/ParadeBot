package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ArmTest extends LinearOpMode{
    private DcMotor arm;
    boolean armRunning = false;

    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.dcMotor.get("arm");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        double power = 0.5;

        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.b) armRunning = true;
            if(gamepad1.x) armRunning = false;
            if(!armRunning){
                if(gamepad1.dpad_right) arm.setPower(0.5);
                if(gamepad1.dpad_left) arm.setPower(-0.5);
                if(!gamepad1.dpad_right && !gamepad1.dpad_left) arm.setPower(0);
                if(gamepad1.a) power -= 0.005;
                if(gamepad1.y) power += 0.005;
            }
            if(armRunning){
                //if(gamepad1.)
            }
        }
    }
}
