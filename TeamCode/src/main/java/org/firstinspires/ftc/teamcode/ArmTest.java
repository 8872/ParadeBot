package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class ArmTest extends LinearOpMode{
    private DcMotorEx arm;
    //private boolean auto = false;


    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.get(DcMotorEx.class, "hand_motor");


        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        while(opModeIsActive()){
            //telemetry.addData("runmode", auto);

            double power = -gamepad1.left_stick_y;
            arm.setPower(power);
            telemetry.addData("power", arm.getPower());
            telemetry.addData("position", arm.getCurrentPosition());

            telemetry.update();

        }
    }
}
