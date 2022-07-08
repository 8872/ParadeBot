package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ParadeTeleOp extends LinearOpMode{
   private DcMotor frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor;

   public void runOpMode() {
       frontLeftMotor = hardwareMap.dcMotor.get("leftFront");
       rearLeftMotor = hardwareMap.dcMotor.get("leftRear");
       frontRightMotor = hardwareMap.dcMotor.get("rightFront");
       rearRightMotor = hardwareMap.dcMotor.get("rightRear");

       frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
       rearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

       telemetry.addData("Status", "Initialized");
       telemetry.update();

       waitForStart();

       while (opModeIsActive()) {
           double frontLeftPower,rearLeftPower,frontRightPower,rearRightPower;
           double y = -gamepad1.left_stick_y;
           double x = gamepad1.right_stick_x;

           double denominator = Math.max(Math.abs(x) + Math.abs(y), 1);

           if(y<-0.15) x = -x;

           frontLeftPower = (y + x) / denominator;
           rearLeftPower = (y + x) / denominator;
           frontRightPower = (y - x) / denominator;
           rearRightPower = (y - x) / denominator;

           frontLeftMotor.setPower(frontLeftPower);
           rearLeftMotor.setPower(rearLeftPower);
           frontRightMotor.setPower(frontRightPower);
           rearRightMotor.setPower(rearRightPower);

           telemetry.addData("FrontLeftPower",frontLeftPower);
           telemetry.addData("RearLeftPower",rearLeftPower);
           telemetry.addData("FrontRightPower",frontRightPower);
           telemetry.addData("RearRightPower",rearRightPower);
           telemetry.update();
       }
   }
}
