package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ArmEncoder extends LinearOpMode {

    private DcMotor arm;

    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.dcMotor.get("arm");

        telemetry.addData("Status ", "Init complete");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.left_bumper) {
                arm.setPower(-0.1);
            }
            if (gamepad1.right_bumper) {
                arm.setPower(0.1);
            }

            telemetry.addData("Arm pos: ", arm.getCurrentPosition());
            telemetry.update();
        }
    }
}
