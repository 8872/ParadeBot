package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class ParadeTeleOp extends LinearOpMode{
   private DcMotor left, right;

   public void runOpMode() {
       left = hardwareMap.dcMotor.get("left");
       right = hardwareMap.dcMotor.get("right");

       right.setDirection(DcMotorSimple.Direction.REVERSE);

       telemetry.addData("Status", "Initialized");
       telemetry.update();

       waitForStart();

       while (opModeIsActive()) {
           double leftPower = -gamepad1.left_stick_y;
           double rightPower = -gamepad1.right_stick_y;

           left.setPower(leftPower);
           right.setPower(rightPower);

           telemetry.addData("left: ",left.getPower());
           telemetry.addData("right: ",right.getPower());
           telemetry.update();
       }
   }
}
