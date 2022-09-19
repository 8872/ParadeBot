package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class ParadeTeleOp extends LinearOpMode{
   private DcMotor left, right, arm;
   private boolean wavehand = false;

   @Override
   public void runOpMode() {
       left = hardwareMap.dcMotor.get("left");
       right = hardwareMap.dcMotor.get("right");
       arm = hardwareMap.dcMotor.get("arm");

       right.setDirection(DcMotorSimple.Direction.REVERSE);
       left.setDirection(DcMotorSimple.Direction.FORWARD);

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

           if (!wavehand) {
               if (moveArmLeft) {
                   //TODO move arm left
                   //eg. arm.setPower(0.1);
               }
               if (moveArmRight) {
                   //TODO move arm right
               }
           }

           //TODO do calculation that is required for the driving process



           telemetry.addData("leftMotor: ",left.getPower());
           telemetry.addData("rightMotor: ",right.getPower());
           telemetry.addData("Arm position: ", arm.getCurrentPosition());
           telemetry.update();
       }
   }
}
