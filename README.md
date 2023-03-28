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


JUNIT5 TESTING ANNOTATION

    ASSERTION
        assertEquals()
        assertArrayEquals()
        assertIterableEquals()
        assertThrows()
        
    HOOKS
        @BeforeAll()
        @AfterAll()
        @BeforeEach()
        @AfterEach()

    @TestInstance(TestInstance.LifeCycle.PER_CLASS)

    @DisplayName()
    @Disabled()
    
    CONDITIONAL EXECUTION
        @EnabledOnOs(OS.LINUX)
        @EnabledOnJRE(JRE.JAVA_11)
        @EnabledIf
        @EnabledIfSystemProperty
        @EnabledIfSystemProperty
        @EnabledIfEnvironmentVariabled

    ASSUMPTION
        assumeThat()
        assumeTrue()

    @AssertAll()

    @Nested

    @RepeatedTest()

    @Tag

    TestInfo/TestReporter -> dependency Injection



