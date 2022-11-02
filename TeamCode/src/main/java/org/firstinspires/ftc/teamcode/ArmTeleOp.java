package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class ArmTeleOp extends LinearOpMode {

    private DcMotor arm;
    private boolean wavehand = false;

    @Override
    public void runOpMode() {
        arm = hardwareMap.dcMotor.get("arm");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
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

            if (!wavehand) {
                if (moveArmLeft) {
                    //TODO change values as nessesary after testing
                    arm.setPower(0.2);
                }
                if (moveArmRight) {
                    //TODO change values as nessesary after testing
                    arm.setPower(-0.2);
                }
            }

            telemetry.addData("Arm position: ", arm.getCurrentPosition());
            telemetry.update();
        }
    }
}
