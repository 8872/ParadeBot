package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.command.drive.DriveFieldCentric;
import org.firstinspires.ftc.teamcode.command.drive.DriveRobotCentric;
import org.firstinspires.ftc.teamcode.command.lift.ManualLift;
import org.firstinspires.ftc.teamcode.subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

@TeleOp(name = "Mini IDK")
public class OpmodeTest extends CommandOpMode {

    private DriveSubsystem drive;
    private ArmSubsystem arm;
    private ManualLift manualLift;
    private DriveRobotCentric robotCentric;
    private DriveFieldCentric fieldCentric;
    private MotorEx fL, fR, bL, bR, leftLift, rightLift;
    private GamepadEx driver1, driver2;
    private RevIMU imu;
    private Button changeCenter;

    @Override
    public void initialize() {
        driver1 = new GamepadEx(gamepad1);
        driver2 = new GamepadEx(gamepad2);

        imu = new RevIMU(hardwareMap);
        imu.init();

        fL = new MotorEx(hardwareMap, "leftFront");
        fR = new MotorEx(hardwareMap, "rightFront");
        bL = new MotorEx(hardwareMap, "leftBack");
        bR = new MotorEx(hardwareMap, "rightBack");

        leftLift = new MotorEx(hardwareMap, "dr4bLeft");
        rightLift = new MotorEx(hardwareMap, "dr4bRight");

        drive = new DriveSubsystem(fL, fR, bL, bR);
        arm = new ArmSubsystem(leftLift, rightLift);

        robotCentric = new DriveRobotCentric(drive, () -> driver1.getLeftX(),
                () -> driver1.getRightX(), () -> driver1.getLeftY());
        fieldCentric = new DriveFieldCentric(drive, () -> driver1.getLeftX(),
                () -> driver1.getLeftY(), () -> driver1.getRightX(), () -> imu.getHeading());

        changeCenter = new GamepadButton(driver1, GamepadKeys.Button.DPAD_DOWN).
                toggleWhenPressed(fieldCentric, robotCentric);

        leftLift.resetEncoder();
        rightLift.resetEncoder();

        manualLift = new ManualLift(arm, () -> driver2.getLeftY()*0.5, () -> driver2.getLeftY()*0.5);

        register(drive, arm);
        drive.setDefaultCommand(robotCentric);
        arm.setDefaultCommand(manualLift);
    }

    @Override
    public void run() {
        super.run();
    }
}
