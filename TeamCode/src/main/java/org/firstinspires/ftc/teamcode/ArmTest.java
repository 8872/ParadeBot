package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ArmTest extends LinearOpMode{
    private DcMotor arm;
    private boolean auto = false;


    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.dcMotor.get("hand_motor");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("runmode", auto);
            telemetry.addData("position", arm.getCurrentPosition());
            if(gamepad1.a){
                auto = !auto;
            }
            if(auto == true){
                arm.setPower(-0.5);
                sleep(1000);
                arm.setPower(0.5);
                sleep(1000);
                /*
                telemetry.addData("position", arm.getCurrentPosition());
                if(!arm.isBusy()){
                    if(arm.getCurrentPosition() > 0){
                        arm.setTargetPosition(-800);
                        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    }else{
                        arm.setTargetPosition(800);
                        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    }
                }
                 */

            }else{
                double power = -gamepad1.left_stick_y;
                arm.setPower(power);
                telemetry.addData("power", arm.getPower());
            }
            telemetry.update();

        }
    }
}
