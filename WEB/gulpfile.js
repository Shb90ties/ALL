-> install gulp globaly
	$ npm install --global gulp
	
-> make gulp a devDependencies on project
	$ npm install --save-dev gulp
		// must have package.json before
			// with npm init
			
-> create gulpfile.js
	$ npm install --save-dev gulp-util
	
-> npm start , in the project folder

-> run gulp file
	$ gulp

// gulpfile.js //________________________//

var gulp  = require('gulp'),
    gutil = require('gulp-util');

	gulp.task // function
	gulp.src // sources
	gulp.dest // output
	gulp.watch // on-change

// .TASK , run a function
gulp.task('default', function() {
  return gutil.log('Gulp is running!')
});

gulp.task('mytask', function() {
  //do stuff
});

gulp.task('dependenttask', ['mytask'], function() {
  //do stuff after 'mytask' is done.
});

// .SRC , points to the files to use
	// uses .pipe to communicate with other plugins
gulp.task('copyHtml', function() {
  // copy any html files in source/ to public/
  gulp.src('source/*.html').pipe(gulp.dest('public'));
});

// .WATCH
gulp.watch('source/javascript/**/*.js', ['jshint']);
			// when any of those files change
	
	-> steps
		$ npm install --save-dev gulp-jshint jshint-stylish
	-> add to file 
		gulp.task('default', ['watch']);
	-> configure
		gulp.task('jshint', function() {
		  return gulp.src('source/javascript/**/*.js')
			.pipe(jshint())
			.pipe(jshint.reporter('jshint-stylish'));
		});
	-> run $ gulp
	-> run $ gulp jshint

	
// SASS
	sass   = require('gulp-sass');
	gulp.task('build-css', function() {
	  return gulp.src('source/scss/**/*.scss')
		.pipe(sass())
		.pipe(gulp.dest('public/assets/stylesheets'));
	});
	
	gulp.task('watch', function() {
	  gulp.watch('source/javascript/**/*.js', ['jshint']);
	  gulp.watch('source/scss/**/*.scss', ['build-css']);
	});

	
	
// gulp-sourcemaps
	    sourcemaps = require('gulp-sourcemaps');

		gulp.task('build-css', function() {
		  return gulp.src('source/scss/**/*.scss')
			.pipe(sourcemaps.init())  // Process the original sources
			  .pipe(sass())
			.pipe(sourcemaps.write()) // Add the map to modified source.
			.pipe(gulp.dest('public/assets/stylesheets'));
		});


// minify & concat
	// used for pulling the project all together

gulp.task('build-js', function() {
  return gulp.src('source/javascript/**/*.js')
    .pipe(sourcemaps.init())
      .pipe(concat('bundle.js'))
      //only uglify if gulp is ran with '--type production'
      .pipe(gutil.env.type === 'production' ? uglify() : gutil.noop()) 
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('public/assets/javascript'));
});
	