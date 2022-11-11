package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.TriMotorDrive;


/** TankDrive
 *
 *  Tank drive. left stick controls left motor, right stick controls right motor.
 *  Strafing is done with the bumpers.
 */
@TeleOp
public class TankDrive extends OpMode {
    TriMotorDrive drive = new TriMotorDrive();

    @Override
    public void init() {
            drive.init(hardwareMap);

    }

    @Override
    public void loop() {
        double left = -gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        double center = 0;


        if (gamepad1.left_bumper) {
            center = - 1;
        } else if (gamepad1.right_bumper){
            center = 1;
        } else {
            center = 0;
        }

        drive.setSidePowers(left, right, center);

    }
}
