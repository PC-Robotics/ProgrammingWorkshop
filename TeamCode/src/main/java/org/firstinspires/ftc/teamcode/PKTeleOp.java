package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "PK TeleOp")
public class PKTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            // sets the power based on if circle is pressed
            if (gamepad1.circle) {
                motor.setPower(1);
            } else {
                motor.setPower(0);
            }

            // sets the power based on how hard the right trigger is pressed
            double MrPower = deadzone(gamepad1.right_trigger);
            motor.setPower(MrPower);

            // sets the power based on the x value of the left stick
            double joystickPower = deadzone(gamepad1.left_stick_x);
            motor.setPower(joystickPower);

            telemetry.addData("Motor Power", motor.getPower());
        }
    }

    public static double deadzone(double input) {
        if (Math.abs(input) < 0.1) {
            return 0;
        } else {
            return input;
        }
    }
}
