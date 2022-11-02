package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class ParadeTeleOp extends LinearOpMode{
   private DcMotor left, right, arm;
   private boolean wavehand = false;
   private double wavePow = 0.2;

   @Override
   public void runOpMode() {
       left = hardwareMap.dcMotor.get("left");
       right = hardwareMap.dcMotor.get("right");
       arm = hardwareMap.dcMotor.get("arm");

       right.setDirection(DcMotorSimple.Direction.REVERSE);
       left.setDirection(DcMotorSimple.Direction.FORWARD);
       arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       telemetry.addData("Status", "Initialized");
       telemetry.update();

       waitForStart();

       while (opModeIsActive()) {
           double leftStickY = gamepad1.left_stick_y;
           double leftStickX = gamepad1.right_stick_x;
           boolean moveArmLeft = gamepad1.left_bumper;
           boolean moveArmRight = gamepad1.right_bumper;

           //resets encoder
           if (gamepad1.x) {
               arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
           }
           //turns on or off the waveHand
           if (gamepad1.y) {
               wavehand = !wavehand;
           }

           if(!arm.isBusy()) {
               if (arm.getCurrentPosition() > 0) {
                   arm.setTargetPosition(-800);
                   arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               } else {
                   arm.setTargetPosition(800);
                   arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               }
           }

           //increase waving speed
           if (gamepad1.dpad_up) {
               wavePow += 0.1;
           }
           if (gamepad1.dpad_down) {
               wavePow -= 0.1;
           }

           if (!wavehand) {
               if (moveArmLeft) {
                   //TODO change values as nessesary after testing
                   arm.setPower(wavePow);
               }
               if (moveArmRight) {
                   //TODO change values as nessesary after testing
                   arm.setPower(wavePow*-1);
               }
           }

           //TODO need to test this to make sure it works properly with the bot
           double denominator = Math.max(Math.abs(leftStickY) + Math.abs(leftStickX), 1);
           double leftPower = (-leftStickY + leftStickX) / denominator;
           double rightPower = (leftStickY + leftStickX) / denominator;

           left.setPower(leftPower);
           right.setPower(rightPower);

           telemetry.addData("LeftMotor", leftPower);
           telemetry.addData("RightMotor", rightPower);
           telemetry.update();


           telemetry.addData("leftMotor: ",left.getPower());
           telemetry.addData("rightMotor: ",right.getPower());
           telemetry.addData("Arm position: ", arm.getCurrentPosition());
           telemetry.update();
       }
   }
}
