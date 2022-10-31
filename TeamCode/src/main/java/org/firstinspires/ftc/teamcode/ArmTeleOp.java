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

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            boolean moveArmLeft = gamepad1.left_bumper;
            boolean moveArmRight = gamepad1.right_bumper;

            if (!wavehand) {
                if (moveArmLeft) {
                    //TODO change values as nessesary after testing
                    arm.setPower(0.1);
                }
                if (moveArmRight) {
                    //TODO change values as nessesary after testing
                    arm.setPower(-0.1);
                }
            } else {
                //TODO add the automation process
            }

            telemetry.addData("Arm position: ", arm.getCurrentPosition());
            telemetry.update();
        }
    }
}
