package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawSlideManager;


/**
 * ArcadeDrive 2 Player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Arcade driving, similar to playing a racing game.
 * See ClawSlideManager.java for information regarding the claw and slide.
 */

@TeleOp(name = "ArcadeDrive2P", group = "auto")
@Disabled
public class ArcadeDrive2p extends ClawSlideManager {
    @Override
    public void loop() {
        telemetry.addData("STATUS", "Running");
        telemetry.update();

        //// DRIVETRAIN
        // Move drivetrain based on left stick movement
        double forward = gamepad1.left_stick_y;
        double right = -gamepad1.left_stick_x;
        drive.setPowers(forward + right, -1 * (forward - right));
        // Debug info
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);

        updateClaw(2);
        updateSlide(2);
    }
}
