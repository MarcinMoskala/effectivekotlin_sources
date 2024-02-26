package f_C4_Item30.s_6

interface Car {
  /**
   * Changes car direction.
   *
   * @param angle Represents position of wheels in
   * radians relatively to car axis. 0 means driving
   * straight, pi/2 means driving maximally right,
   * -pi/2 maximally left.
   * Value needs to be in (-pi/2, pi/2)
   */
  fun setWheelPosition(angle: Float)

  /**
   * Decelerates vehicle speed until 0.
   *
   * @param pressure The percentage of brake pedal use.
   * Number from 0 to 1 where 0 means not using break
   * at all, and 1 means maximal pedal pedal use.
   */
  fun setBreakPedal(pressure: Double)

  /**
   * Accelerates vehicle speed until max speed possible
   * for the user.
   *
   * @param pressure The percentage of gas pedal use.
   * Number from 0 to 1 where 0 means not using gas at
   * all, and 1 means maximal gas pedal use.
   */
  fun setGasPedal(pressure: Double)
}
