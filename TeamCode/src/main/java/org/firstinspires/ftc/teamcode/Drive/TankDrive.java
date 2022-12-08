package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/**
 * TankDrive
 * Tank drive. left stick controls left motor, right stick controls right motor.
 */
@TeleOp(name = "TankDrive", group = "auto")
public class TankDrive extends OpMode {
    // Initialize classes from other files
    DualMotorDrive drive;
    ClawCore claw;
    SlideCore slide;

    // Define classes from other files
    @Override
    public void init() {
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        telemetry.addData("DRIVE MODE: ", "TankDrive 1 Player");
        telemetry.addData("STATUS: ", "Initialized");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.update();

        //// DRIVETRAIN
        // Move left/right wheels based on left/right stick movement
        double left = gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        drive.setPowers(left, right);
        drive.telemetry(telemetry, left, right);

        //// CLAW
        // Open/close claw if A/B is pressed (respectively)
        if (gamepad1.a) {
            claw.clawOpen();
        } else if (gamepad1.b) {
            claw.clawClose();
        }
        claw.telemetry(telemetry);

        //// SLIDE
        // Move slide based on LT/RT presses
        double slidePower = (-gamepad1.left_trigger + gamepad1.right_trigger);
        slide.setSlidePower(slidePower);
        slide.telemetry(telemetry, slidePower);
    }
}
