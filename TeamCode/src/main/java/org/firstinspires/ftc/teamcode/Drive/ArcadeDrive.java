package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/**
 * ArcadeDrive
 * Arcade driving, similar to playing a racing game.
 */

@TeleOp(name = "WIP ArcadeDrive", group = "auto")
public class ArcadeDrive extends OpMode {
    // Initialize classes from other files
    DualMotorDrive drive;
    ClawCore claw;
    SlideCore slide;

    // Define classes from other files
    @Override
    public void init() { //INIT - When OpMode is init but not Started
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        telemetry.addData("DRIVE MODE: ", "ArcadeDrive 1 Player");
        telemetry.addData("STATUS: ", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "20718");
    }

    @Override
    public void loop() { //START - after start button is pushed
        telemetry.addData("STATUS: ", "Running");
        telemetry.update();

        //// DRIVETRAIN
        // Move drivetrain based on left stick movement
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        drive.setPowers(forward + right, -1 * (forward - right) );
        // Debug info
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);

        //// CLAW
        // Open/close claw if A/B is pressed (respectively)
        if (gamepad1.a){
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
